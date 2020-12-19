package com.coteded.JspDemo.service.aws;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

public class S3Upload {
	private String contentType = "plain/text";
	Regions clientRegion = Regions.EU_CENTRAL_1;
	String bucketName = "natsheh-bucket";

	public void upload(String filePath, String keyName) throws IOException {
		try {

			AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withRegion(clientRegion).build();

			// Upload a file as a new object with ContentType and title specified.
			PutObjectRequest request = new PutObjectRequest(bucketName, keyName, new File(filePath));
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentType(contentType);
			metadata.addUserMetadata("title", "this is an image");
			request.setMetadata(metadata);
			s3Client.putObject(request);
		} catch (AmazonServiceException e) {
			// The call was transmitted successfully, but Amazon S3 couldn't process
			// it, so it returned an error response.
			e.printStackTrace();
		} catch (SdkClientException e) {
			// Amazon S3 couldn't be contacted for a response, or the client
			// couldn't parse the response from Amazon S3.
			e.printStackTrace();
		}
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
