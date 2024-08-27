import java.sql.*;

public class TellerFunctions {

	DBConnector dbConnector = DBConnector.getInstance();
    Connection connection = dbConnector.getConnection();
    StringBuilder htmlContent = new StringBuilder();
	interface TellerTasks1 {
		public String registerCustomer(String firstName, 
				String lastName, String nationality, String region, 
				String zone, String woreda, String kebele, String gender, 
				String email, String occupation, String phoneNumber, String dateofbirth);
		public String makeWithdraw();
		public String makeDeposit(String name, int accountNumber, double amount);
		public String makeTransfer();
		public String checkBalance();
		public String seeCustomerTransaction();
		public boolean writeLogFile(double prevBalance, double currentBalance, int accountNumber, Timestamp unixTime, String tranType);
	}
	
	class ImplementationOfTellerTasks implements TellerTasks1{
		 
		 
		 

		@Override 
		public String  registerCustomer(String firstName, 
				String lastName, String nationality, String region, 
				String zone, String woreda, String kebele, String gender, 
				String email, String occupation, String phoneNumber, String dataofbirth){
			int accountNumber = 0; 
			
		Date date =	new java.sql.Date(System.currentTimeMillis());
			boolean status = false;
			double balance = 0.0;
			boolean closed = false;
			String insertionQuery;
			if (email.isEmpty()) {
				insertionQuery = "INSERT INTO customer (account_number, first_name, last_name, phone_no, sex, status, nationality, region, zone, woreda, kebele, open_date, job_type, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        } else {
	        	insertionQuery = "INSERT INTO customer (account_number, first_name, last_name, phone_no, sex, status, nationality, region, zone, woreda, kebele, open_date, job_type, email, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        }

			
			

			boolean notunique = true;
			try {
				// generating a unique 7 digit account number
				while(notunique) {
					accountNumber = (int) (Math.random() * (9999999) + 1000000);
					String queryForACNO = "SELECT * FROM customer WHERE account_number = ?";
		        PreparedStatement getACC = connection.prepareStatement(queryForACNO);
		        getACC.setInt(1, accountNumber);
		        ResultSet resultSet = getACC.executeQuery();
		        if(!resultSet.next()) {
		        	notunique = false;
		        }
		        resultSet.close();
		        getACC.close();
				}
				PreparedStatement comitWrite = connection.prepareStatement(insertionQuery);
				
				comitWrite.setInt(1, accountNumber);
				comitWrite.setString(2, firstName);
				comitWrite.setString(3, lastName);
				comitWrite.setString(4, phoneNumber);
	            comitWrite.setString(5, gender);
	            comitWrite.setBoolean(6, false);
	            comitWrite.setString(7, nationality);
	            comitWrite.setString(8, region);
	            comitWrite.setString(9, zone);
	            comitWrite.setString(10, woreda);
	            comitWrite.setString(11, kebele);
	            comitWrite.setDate(12, new java.sql.Date(System.currentTimeMillis()));
	            comitWrite.setString(13, occupation);
	            if (!email.isEmpty()) {
	            	comitWrite.setString(14, email);
	            	comitWrite.setDate(15, java.sql.Date.valueOf(dataofbirth));
	            } else {
	            	comitWrite.setDate(14, java.sql.Date.valueOf(dataofbirth));
	            }
	            int rowsAffected = comitWrite.executeUpdate();
	            
	            if(rowsAffected != 0) {
	            	
	            	htmlContent.append("<div class=\"newaccount\">")
	                .append("<div>")
	                .append("<label for=\"name\">Name</label><br>")
	                .append("<input type=\"text\" name=\"accholdername\" readonly value=\"")
	                .append(firstName).append(" ").append(lastName).append("\"><br>")
	                .append("</div>")
	                .append("<div>")
	                .append("<label for=\"name\">Account Number</label>")
	                .append("<input type=\"text\" name=\"accnumber\" readonly value=\"")
	                .append(accountNumber).append("\"><br>")
	                .append("</div>")
	                .append("</div>");
	            }
						       
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			

			return htmlContent.toString();
		}
		
		@Override 
		public String makeWithdraw(){
			
			
			return htmlContent.toString();
		}
		
		
		@Override 
		public String makeTransfer(){
			return "";
		}
		
		
		@Override 
		public String checkBalance(){
			return "";
		}
		
		@Override 
		public String seeCustomerTransaction(){
			return "";
		}
		
		@Override
		public String makeDeposit(String name, int accountNumber, double amount) {
		    StringBuilder htmlContent = new StringBuilder();

		    try {
		        String balanceQuery = "SELECT balance FROM customer WHERE account_number = ?";
		        PreparedStatement getBalance = connection.prepareStatement(balanceQuery);
		        getBalance.setInt(1, accountNumber);
		        ResultSet resultSet = getBalance.executeQuery();
		        
		        long unixTime = System.currentTimeMillis() / 1000L;  
		        String tranType = "deposit";
		        double prevBalance = 0.0;
		        boolean isNotActive = false;
		        
		        if (resultSet.next()) {
		        	if(resultSet.wasNull()) {
		        		isNotActive = true;
		        		 prevBalance = 0.0;
		        	}
		        	else {
		        		prevBalance = resultSet.getDouble("balance");
		        	}
		            
		        }

		        double currentBalance = prevBalance + amount;
		     
		        Timestamp DepositTime = new Timestamp(unixTime * 1000);
		        String depositSQL = "INSERT INTO deposit (amount, date, account_number) VALUES (?, ?, ?)";
		        PreparedStatement statement = connection.prepareStatement(depositSQL);
		        statement.setDouble(1, amount);
		        statement.setTimestamp(2, DepositTime);
		        statement.setInt(3, accountNumber);
		        int rowsAffected = statement.executeUpdate();
		        htmlContent.append("<div"+ DepositTime +" >");
		        if(rowsAffected > 0) {
		        	 boolean logRegistered = writeLogFile(prevBalance, currentBalance, accountNumber, DepositTime, tranType);
		        if (logRegistered) {
		        	
		        	String updateBlancequery = "UPDATE customer SET balance = ? WHERE account_number = ?";
		            PreparedStatement updateBalance = connection.prepareStatement(updateBlancequery);
		            updateBalance.setDouble(1, currentBalance);
		            updateBalance.setInt(2, accountNumber);
		            updateBalance.executeUpdate();
		        	
		        	if(isNotActive) {
		        		 String updateStatus = "UPDATE customer SET status = ? WHERE account_number = ?";
		            PreparedStatement updateStatement = connection.prepareStatement(updateStatus);
		            updateStatement.setBoolean(1, true);
		            updateStatement.setInt(2, accountNumber);
		            updateStatement.executeUpdate();
		        	}
		           

		            htmlContent.append("<div class=\"depositinfo\">")
		                       .append("<div><h3>--------KURATH BANK--------</h3></div>")
		                       .append("<div class=\"depositer\"><p>Name: ").append(name).append("</p></div>")
		                       .append("<div class=\"depositeraccount\"><p>Account number: ").append(accountNumber).append("</p></div>")
		                       .append("<div class=\"depositamount\"><p>Deposit: ").append(amount).append("</p></div>")
		                       .append("<div class=\"depositamount\"><p>Date: ").append(DepositTime).append("</p></div>")
		                       .append("<div><h3>---------------------------</h3></div>")
		                       .append("</div>");
		        } else {
		            String deleteDeposit = "DELETE FROM deposit WHERE date = ? AND account_number = ?";
		            PreparedStatement deleteStatement = connection.prepareStatement(deleteDeposit);
		            deleteStatement.setTimestamp(1, DepositTime);
		            deleteStatement.setInt(2, accountNumber);
		            deleteStatement.executeUpdate();
		            htmlContent.append("<div"+ DepositTime +" >");
		            htmlContent.append("<div class=\"depositform\">")
		                       .append("<h1>UNSUCCESSFUL DEPOSIT!!</h1>")
		                       .append("<h3>try again</h3>")
		                       .append("</div>");
		        }
		        }else {
			        htmlContent.append("<div class='depositform'><h1>UNEXPECTED ERROR OCCURRED IN FETCHING DATA</h1> "+ accountNumber +" </div>");

		        }
		       
		    } catch (SQLException e) {
		    	
		        e.fillInStackTrace();
		        htmlContent.append("<div class='depositform'><h1>UNEXPECTED ERROR OCCURRED IN FETCHING DATA</h1> " +  e.getMessage()+ accountNumber +" </div>");
		    }

		    return htmlContent.toString();
		}

		
		@Override
		public boolean writeLogFile(double prevBalance, double currentBalance, int accountNumber, Timestamp DepositTime, String tranType)
		{
			 String tableName = "";
		        String transactionId = "";
		        String accountNo = "";
			if (tranType.equals("deposit")) {
                tableName = "deposit";
                transactionId = "deposit_id";
                accountNo = "account_number";
            } else if (tranType.equals("withdraw")) {
                tableName = "withdraw";
                transactionId = "withdraw_id";
                accountNo = "account_number";
            } else if (tranType.equals("transfer")) {
                tableName = "transfer";
                transactionId = "transfer_id";
            }
               /* if (session.getAttribute("cusAccount").equals("sender_account")) {
                    accountNo = "sender_account";
                } else if (session.getAttribute("cusAccount").equals("receiver_account")) {
                    accountNo = "receiver_account";
                }*/	
                
			String getTransactionIdQuery = "SELECT " + transactionId + " FROM " + tableName + " WHERE " + accountNo + " = ? AND date = ?";                
			  try  {
                	PreparedStatement statement = connection.prepareStatement(getTransactionIdQuery);
                    statement.setInt(1, accountNumber);
                    statement.setTimestamp(2, DepositTime);
                  ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            int transactionIdValue = resultSet.getInt(transactionId);
                            String logSql = "INSERT INTO log_file(account_no, transaction_type, transaction_id, prev_amount, new_amount, date) VALUES (?, ?, ?, ?, ?, ?)";
                            
                            	PreparedStatement logStatement = connection.prepareStatement(logSql);

                                logStatement.setInt(1, accountNumber);
                                logStatement.setString(2, tranType);
                                logStatement.setInt(3, transactionIdValue);
                                logStatement.setDouble(4, prevBalance);
                                logStatement.setDouble(5, currentBalance);
                                logStatement.setTimestamp(6, DepositTime);
                                int row = logStatement.executeUpdate();
                                if(row > 0) {
                                	return true;
                                	}else {
                                	return false;
                                	}
                              }
                           return false;
                        }  
              
             catch (SQLException e) {
            	    e.printStackTrace();                
            }
                return false;
            }
			
	}
}
                    
            
