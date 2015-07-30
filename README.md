# autonomy-teamsite-soap-api
Connect TeamSite using com.interwoven.cssdk.factory.CSSOAPFactory

Get following TeamSite related jar files and add to classpath in eclipse:

axis.jar
commons-codec-1.4.jar
commons-discovery-0.2.jar
commons-io-1.4.jar
commons-lang-2.4.jar
commons-logging.jar
commons-pool-1.4.jar
cssdk_sci.jar
cssdkiface.jar
cssdkjava.jar
cssdksoap.jar
dom4j-1.6.1.jar
hopi.jar
jaxen-1.1.1.jar
jaxrpc.jar
log4j-1.2.13.jar
log100.jar
saaj-api-1.3.jar
sci_hopi.jar
searchiface.jar
serverutils100.jar
sharedutils100.jar
slf4j-api-1.7.12.jar
slf4j-simple-1.7.12.jar
utild_hopi.jar
xercesImpl.jar
activation.jar
mail.jar


TeamSite Config properties file:

com.interwoven.cssdk.factory.CSFactory=com.interwoven.cssdk.factory.CSSOAPFactory
defaultTSServer=<SERVERNAME>
ts.server.os=win
username=<DOMAIN\\USERNAME>
password=<PASSWORD>
role=Master
accessBaseURL=http://<SERVERNAME>
serviceBaseURL=http://<SERVERNAME>

