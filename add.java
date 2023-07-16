import java.util.Scanner;

class InvalidUserException extends Exception {
    public String getMessage() {
        return "Invalid card details,try again";
    }
}

class ATM {
    int Account_Num = 1234;
    int Password = 9999;
    int An, Pwd;

    void accecptInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the your account number:");
        An = scan.nextInt();
        System.out.println("Enter the your account Password:");
        Pwd = scan.nextInt();
    }

    void verify() throws InvalidUserException {
        if (Account_Num == An && Password == Pwd) {
            System.out.println("Collect your money");
        } else {
            InvalidUserException I = new InvalidUserException();
            System.out.println(I.getMessage());
            throw I;
        }
    }
}

class Bank {
    void Initiate() {
        ATM a = new ATM();
        try {
            a.accecptInput();
            a.verify();
        } catch (InvalidUserException e) {
            try {
                a.accecptInput();
                a.verify();
            } catch (InvalidUserException f) {
                try {
                    a.accecptInput();
                    a.verify();
                } catch (InvalidUserException h) {
                    System.out.println("Your card is Blocked!!");
                    System.exit(0);
                }
            }
        }
    }
}

class demo {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.Initiate();
    }
}