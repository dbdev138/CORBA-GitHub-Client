package APIConnection;


/**
* APIConnection/GitHubHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from API.idl
* Thursday, 31 March 2016 12:29:02 o'clock BST
*/

abstract public class GitHubHelper
{
  private static String  _id = "IDL:APIConnection/GitHub:1.0";

  public static void insert (org.omg.CORBA.Any a, APIConnection.GitHub that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static APIConnection.GitHub extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (APIConnection.GitHubHelper.id (), "GitHub");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static APIConnection.GitHub read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_GitHubStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, APIConnection.GitHub value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static APIConnection.GitHub narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof APIConnection.GitHub)
      return (APIConnection.GitHub)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      APIConnection._GitHubStub stub = new APIConnection._GitHubStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static APIConnection.GitHub unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof APIConnection.GitHub)
      return (APIConnection.GitHub)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      APIConnection._GitHubStub stub = new APIConnection._GitHubStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}