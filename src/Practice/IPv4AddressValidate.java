package Practice;

public class IPv4AddressValidate {
    private static void validate(String str){
        try {
            String[] arr = str.split("\\.");
            if (arr.length>4)
                throw new Exception("Address length is incorrect.");
            for(String s: arr){
                if(Integer.parseInt(s)<0 || Integer.parseInt(s)>255)
                    throw new Exception("value should be in range 0 to 255");
            }
            System.out.println("Valid");
        } catch (NumberFormatException e) {
            System.out.println("Invalid. Address should contain only numbers");
        } catch (Exception e){
            System.out.println("Invalid "+e.getMessage());
        }

    }

    public static void main(String[] args){
        String address="126.29.0.12";
        validate(address);
    }
}
