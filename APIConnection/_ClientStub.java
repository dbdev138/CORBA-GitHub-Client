package APIConnection;


/**
* APIConnection/_ClientStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from API.idl
* Thursday, 31 March 2016 12:29:02 o'clock BST
*/

public class _ClientStub extends org.omg.CORBA.portable.ObjectImpl implements APIConnection.Client
{

  public void receiveBasicUserData (String jsonShowInfo)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("receiveBasicUserData", true);
                $out.write_string (jsonShowInfo);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                receiveBasicUserData (jsonShowInfo        );
            } finally {
                _releaseReply ($in);
            }
  } // receiveBasicUserData

  public void receiveRepoDetails (String jsonShowInfo)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("receiveRepoDetails", true);
                $out.write_string (jsonShowInfo);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                receiveRepoDetails (jsonShowInfo        );
            } finally {
                _releaseReply ($in);
            }
  } // receiveRepoDetails

  public void receiveDeveloperLanguages (String jsonShowInfo)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("receiveDeveloperLanguages", true);
                $out.write_string (jsonShowInfo);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                receiveDeveloperLanguages (jsonShowInfo        );
            } finally {
                _releaseReply ($in);
            }
  } // receiveDeveloperLanguages

  public void receiveRepoCount (String jsonShowInfo)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("receiveRepoCount", true);
                $out.write_string (jsonShowInfo);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                receiveRepoCount (jsonShowInfo        );
            } finally {
                _releaseReply ($in);
            }
  } // receiveRepoCount

  public void receiveCloneUrl (String jsonShowInfo)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("receiveCloneUrl", true);
                $out.write_string (jsonShowInfo);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                receiveCloneUrl (jsonShowInfo        );
            } finally {
                _releaseReply ($in);
            }
  } // receiveCloneUrl

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:APIConnection/Client:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ClientStub
