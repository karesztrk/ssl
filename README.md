# Oracle WebLogic two-way SSL example #

Use the resources attached to simulate two-way SSL communication between a client and a WebLogic server.

Use *ServerKeyStore* and *ServerTrustStore* to set up an SSL based server. Passwords are *"storepass"* and *"DemoTrustKeyStorePassPhrase"* respectively.  

*ScalaApacheHttpClient* already contains the keystore and the truststore set via System properties.

For more information about the issued commands and WebLogic SSL administration visit: http://weblogic-tips.com/2010/05/20/two-way-ssl-on-weblogic-server/

**Note: the certs are bound to the following hostname: *"Karesz-PC"***

## Resources ##

| File name | Description |
| -------- | -------- |
| CertGenCA | CA certificate in DER and PEM format |
| ClientCert | A client public key in DER and PEM format |
| ClientKey | A client private key in DER and PEM format |
| ClientKeyStore | A key store (private key) for a client containing the private key from above |
| client-pkcs-12-cert | Similar key store (private key) for a client in PKCS12 format (used by browser) |
| ClientTrustStore | Trust store (public key) containing the trusted parties. For example servers. |
| myCert | Server certificate (signed private key) in PEM format. ServerKey + CertGenCA |
| ServerCert | Server public key in DER and PEM format |
| ServerKey | Server private key in DER and PEM format |
| ServerKeyStore | Server key store (private key) containing its own key called 'mykey' |
| ServerTrustStore | Server trust store (public key) containing the trusted parties (originally copied from WebLogic\...\Demotrust.jks) |