package MainPackage;
 import org.apache.poi.ss.formula.functions.FinanceLib;
 import java.util.Scanner;
public class finance {
	public static void main(String[] args){
	double YearsToWork = -1;
	double SavingsReturn = -1;
	double YearsRetired = -1;
	double RetiredReturn = -1;
	double RequiredIncome = -1;
	double MonthlySSI = -1;
	Scanner input = new Scanner(System.in);
	System.out.println("How many years do you plan on working?");
	YearsToWork = input.nextDouble();
	while (SavingsReturn < 0 || SavingsReturn > 20) {
	System.out.println("What is your expected average return on investment?(Between 0-20%)");
	SavingsReturn = input.nextDouble();
	}
	System.out.println("How many years do you plan to live after retirement?");
	YearsRetired = input.nextDouble();
	while (RetiredReturn < 0 || RetiredReturn > 3) {
	System.out.println("What is your expected annual return while retired?(Between 0-3%)");
	RetiredReturn = input.nextDouble();
	}
	System.out.println("What is your monthly required income for retirement?");
	RequiredIncome = input.nextDouble();
	System.out.println("How much do you plan to receive in SSI per month?");
	MonthlySSI = input.nextDouble();
	
	double PV;
	double r1 = ((RetiredReturn/100)/12);
	double n1 = (YearsRetired*12);
	double y1 = (RequiredIncome-MonthlySSI);
	double f1 = 0;
	boolean t1 = false;
	
	PV = FinanceLib.pv(r1, n1, y1, f1, t1);
	double PMT;
	double r2 = ((SavingsReturn/100)/12);
	double n2 = YearsToWork*12;
	double p2 = 0;
	double f2 = PV;
	boolean t2= false;
	PMT = FinanceLib.pmt(r2, n2, p2, f2, t2);
	PMT = Math.floor(PMT*100)/100;
	System.out.println("You need to save " + PMT + " dollars per month to retire.");
	}
}
