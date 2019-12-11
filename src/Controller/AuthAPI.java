package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AuthAPI {
	public static Connection connection;
	public static Statement statement;
//	public static void main(String[] args) throws Exception {
//		Connection connection = null;
//		Statement statement = null;
//		String tableName = "users";
//		boolean checklogin = false;
//		
//		statement = connectDB(connection, statement);
////		createUserTable(statement, tableName);
//
//		String name;
//		String id;
//		String password;
//		String repassword;
//		Scanner scanner = new Scanner(System.in);
//
////		name = scanner.next();
////		id = scanner.next();
////		password = scanner.next();
////		repassword = scanner.next();
////		register(name, id, password, repassword, statement);
//
//		id = scanner.next();
//		password = scanner.next();
//		checklogin = login(id, password, statement);
//		if (checklogin) {
//
//			ResultSet resultSet = statement.executeQuery("select * from " + tableName);
//			while (resultSet.next()) {
//				System.out.printf("name: %s\nid: %s\npassword: %s\n\n", new Object[] { resultSet.getString("name"),
//						resultSet.getString("userid"), resultSet.getString("userpw") });
//			}
//			resultSet.close();
//		}
//	}

	public static void connectDB() throws Exception {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.err.print(e);
		}

		connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/chajy/eclipse-workspace/Orchard/src/users.db");
		statement = connection.createStatement();
	}

	public static void disconnectDB() throws Exception {
		connection.close();
	}

	public static void createUserTable(String tableName) throws Exception {
		statement.execute("create table " + tableName + " (" + "idx integer primary key autoincrement,"
				+ "name char(7) not null," + "userid char(20) not null," + "userpw char(20) not null)");
	}

	public static void register(String iname, String iuserid, String iuserpw, String irepw) {
		// 아이디 중복 검사 필요

		if (iuserpw.equals(irepw)) {
			try {
				statement.execute("insert into users (name, userid, userpw) values (" + "'" + iname + "'" + "," + "'"
						+ iuserid + "'" + "," + "'" + iuserpw + "'" + ")");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("비밀번호를 확인해주세요.");
		}
	}

	public static boolean login(String id, String password) throws Exception {
		
		ResultSet resultSet = null;
		boolean loginCheck = false;
		try{
			resultSet = statement
				.executeQuery("select * from users where userid=" + "'" + id + "' and userpw=" + "'" + password + "'");
		} catch(SQLException e) {
			System.err.println(e);
		}
		
		loginCheck = resultSet.next();
		if (!loginCheck) {
			System.out.println("login failed");
			return false;
		} else {
			if (resultSet.getString("userid").equals(id) && resultSet.getString("userpw").equals(password)) {
				System.out.println("login success");
				return true;
			} else {
				System.out.println("Check your id or password");
				return false;
			}
		}
	}
}
