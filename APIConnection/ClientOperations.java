package APIConnection;


/**
* APIConnection/ClientOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from API.idl
* Thursday, 31 March 2016 12:29:02 o'clock BST
*/

public interface ClientOperations 
{
  void receiveBasicUserData (String jsonShowInfo);
  void receiveRepoDetails (String jsonShowInfo);
  void receiveDeveloperLanguages (String jsonShowInfo);
  void receiveRepoCount (String jsonShowInfo);
  void receiveCloneUrl (String jsonShowInfo);
} // interface ClientOperations