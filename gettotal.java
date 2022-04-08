package Project;

public class gettotal {
	private static String userId;
	private static String total;
	private static int voucherid;
	private static double voucherprice;
	
	public static void senduserid(String useridin)
	{
		userId = useridin;
	}
	
	public static String getuserid()
	{
		return userId;
	}
	
	public static void sendtotal(String totalin)
	{
		total = totalin;
	}
	
	public static String getttotal()
	{
		return total;
	}
	
	public static void sendvoucher(int voucherin)
	{
		voucherid = voucherin;
	}
	
	public static int getvoucher()
	{
		return voucherid;
	}
	
	public static void sendvoucherprice(double voucherpricein)
	{
		voucherprice = voucherpricein;
	}
	
	public static double getvoucherprice()
	{
		return voucherprice;
	}
}
