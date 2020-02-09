package com.app.game.fruitninjar.model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/**
 * <h1>Desktop-Fruit-Ninja-App</h1>This is Desktop Fruit Ninjar App using Java programming language. 
 *Used MVC architecture pattern, singleton, strategy and factory design pattern.
 *Stored user data in Amazon SimpleDB and showed user information by update HTML file stored in Amazon S3
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class UserDB {

	public static final String bucketName = "oofinalproject";
	public static final String domainName = "oofinalproject";
	public static final int maskForInteger = 1000000;
	private static UserDB userdb = null;
	//private AmazonSimpleDB db;
	//private AmazonS3 s3;

	private UserDB() {
		String accessKey = "your_access_key";
		String secretKey = "your_secret_key";
//		this.db = loginSimpleDB(accessKey, secretKey);
//		this.s3 = loginS3(accessKey, secretKey);
//		if (this.db == null) {
//			System.out.println("not login to db");
//		} else {
//			System.out.println("login to db");
//		}
		createDomain();

	}

	public static UserDB getInstance() {
		if (userdb == null)
			userdb = new UserDB();
		return userdb;
	}

	// create simpleDB account with accesskey and secretkey
//	public static AmazonSimpleDB loginSimpleDB(String accessKey, String secretKey) {
//		AWSCredentials myCredentials = new BasicAWSCredentials(accessKey, secretKey);
//		AmazonSimpleDB db = new AmazonSimpleDBClient(myCredentials);
//		return db;
//	}

	// create s3 account with accesskey and secretkey
//	public AmazonS3 loginS3(String accessKey, String secretKey) {
//		AWSCredentials myCredentials = new BasicAWSCredentials(accessKey, secretKey);
//		AmazonS3 s3 = new AmazonS3Client(myCredentials);
//		return s3;
//	}

	// create a domain of oofinalproject if it is not exist in SimpleDB
	public void createDomain() {
		//db.createDomain(new CreateDomainRequest(domainName));
	}

	// add user information into simpleDB
//	public void addUser(User user) {
//		List<ReplaceableItem> data = new ArrayList<ReplaceableItem>();
//
//		ReplaceableItem userItem = new ReplaceableItem(user.getUsername()).withAttributes(
//				new ReplaceableAttribute("username", user.getUsername(), true),
//				new ReplaceableAttribute("date", user.getDate(), true),
//				new ReplaceableAttribute("score", Integer.toString(user.getScore() + maskForInteger), true),
//				new ReplaceableAttribute("password", user.getPassword(), true));
//
//		data.add(userItem);
//		db.batchPutAttributes(new BatchPutAttributesRequest(domainName, data));
//		// SimpleDB sometime may has latency issue and if write to Amazon S3
//		// immediately
//		// data may have not been updated yet, so sleep for 3 seconds
//		// before write to Amazon S3
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			createObject();
//		} catch (AmazonServiceException e) {
//			e.printStackTrace();
//		} catch (AmazonClientException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// remove data in SimpleDB( for testing )
//	public void destroyDomain() {
//		DeleteDomainRequest deleteDomainRequest = new DeleteDomainRequest(domainName);
//		db.deleteDomain(deleteDomainRequest);
//	}
//
//	// list all users information
//	public List<Item> listUsers() {
//		String selectExpression = "Select * from" + " `oofinalproject`";
//		return searchBy(selectExpression);
//	}
//
//	// search data in SimpleDB by query
//	public List<Item> searchBy(String selectExpression) {
//		SelectRequest selectRequest = new SelectRequest(selectExpression);
//		// System.out.println( "search by" );
//
//		List<Item> items = db.select(selectRequest).getItems();
//		return items;
//	}
//
//	// create a bucket
//	public void createBucket() {
//		Region usWest2 = Region.getRegion(Regions.US_WEST_2);
//		s3.setRegion(usWest2);
//		s3.createBucket(domainName);
//	}
//
//	// create a object
//	public void createObject() throws AmazonServiceException, AmazonClientException, IOException {
//		String objectName = "oofinalprojectobject";
//		PutObjectRequest request = new PutObjectRequest(bucketName, objectName, createSampleFile());
//		request.setCannedAcl(CannedAccessControlList.PublicRead);
//		s3.putObject(request);
//	}
//
//	// create html file and store in s3
//	private File createSampleFile() throws IOException {
//
//		File file = File.createTempFile("aws-java-sdk-", ".html");
//		file.deleteOnExit();
//		String selectExpression = "Select * from `oofinalproject` where score is not null order by score desc";
//		List<Item> items = searchBy(selectExpression);
//
//		Writer writer = new OutputStreamWriter(new FileOutputStream(file));
//		writer.write("<!DOCTYPE html>\n");
//		writer.write("<html>\n");
//		writer.write("<body>\n");
//		writer.write("<table>\n");
//		writer.write("<tr>");
//		writer.write("<th>Username</th>\n");
//		writer.write("<th>Score</th>\n");
//		writer.write("<th>Date</th>\n");
//		writer.write("</tr>\n");
//
//		int size = items.size();
//		for (int i = 0; i < size; i++) {
//			writer.write("<tr>\n");
//			writer.write("<td>" + items.get(i).getAttributes().get(0).getValue() + "</td>\n");
//			writer.write("<td>"
//					+ Integer
//							.toString(Integer.parseInt(items.get(i).getAttributes().get(1).getValue()) - maskForInteger)
//					+ "</td>\n");
//			writer.write("<td>" + items.get(i).getAttributes().get(2).getValue() + "</td>\n");
//			writer.write("</tr>\n");
//		}
//
//		writer.write("</table>\n");
//		writer.write("</body>\n");
//		writer.write("</html>\n");
//		writer.close();
//		return file;
//	}

}