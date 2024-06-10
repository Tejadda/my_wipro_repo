package com.DAY_28;
//Sensitive object containing a secret key
class SensitiveObject {
 private String secretKey;

 public SensitiveObject(String secretKey) {
     this.secretKey = secretKey;
 }

 public String getSecretKey() {
     return secretKey;
 }
}

//Proxy class that controls access to the sensitive object
class Proxy1 {
 private SensitiveObject sensitiveObject;
 private String password;

 public Proxy1(SensitiveObject sensitiveObject, String password) {
     this.sensitiveObject = sensitiveObject;
     this.password = password;
 }

 public String getSecretKey(String providedPassword) {
     if (providedPassword.equals(password)) {
         return sensitiveObject.getSecretKey();
     } else {
         throw new RuntimeException("Invalid password");
     }
 }
}

//Client code
public class Proxy {
 public static void main(String[] args) {
     SensitiveObject sensitiveObject = new SensitiveObject("my_secret_key");
     Proxy1 proxy = new Proxy1(sensitiveObject, "my_password");

     try {
         String secretKey = proxy.getSecretKey("my_password");
         System.out.println("Secret key: " + secretKey);
     } catch (RuntimeException e) {
         System.out.println("Error: " + e.getMessage());
     }

     try {
         String secretKey = proxy.getSecretKey("wrong_password");
         System.out.println("Secret key: " + secretKey);
     } catch (RuntimeException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}