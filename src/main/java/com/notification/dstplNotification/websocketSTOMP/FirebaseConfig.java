package com.notification.dstplNotification.websocketSTOMP;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

	@SuppressWarnings("deprecation")
	public FirebaseApp firebaseApp() throws IOException{
		FileInputStream serviceAccount =
				new FileInputStream("src/main/resources/firebase-service-account.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .build();

				return FirebaseApp.initializeApp(options);

	}
}
