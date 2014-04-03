package com.scispike.effectivejava.solution.ch05;


public enum EurozoneCountry {
	Austria(8404252, 384908),
	Belgium(10918405,	468522),
	Cyprus(838896, 24910),
    Estonia(1340194, 19120),
    Finland(5375276, 237512),
    France(65075373, 2649390),
    Germany(81751602, 3330032),
    Greece(11325897, 329924),
    Ireland(4480858, 227193),
    Italy(60626442, 2112780),
    Luxembourg(511840, 52449),
    Malta(417617, 7449),
    Netherlands(16655799,	792128),
    Portugal(10636979, 227676),
    Slovakia(5435273, 87642),
    Slovenia(2050189, 48477),
    Spain(47190493, 1460250);
	
	private long population;
	private long GDPInMillions;

	private EurozoneCountry(long population, long GDPInMillions) {
		this.population = population;
		this.GDPInMillions = GDPInMillions;
	}
	
	public long getPopulation() {
		return this.population;
	}
	
	public long getGDPInMillions() {
		return this.GDPInMillions;
	}
	
	public long getGDPPerCapita() {
		return (this.GDPInMillions * 1000000)/this.population;
	}
	
	public static long getEurozonePopulation() {
		long totalEurozonePopulation = 0;
		
		for (EurozoneCountry c : EurozoneCountry.values())
			totalEurozonePopulation += c.getPopulation();
				
		return totalEurozonePopulation;
	}
	
	public static long getEurozoneGDPInMillions() {
		long totalEurozoneGDP = 0;
		
		for (EurozoneCountry c : EurozoneCountry.values())
			totalEurozoneGDP += c.getGDPInMillions();
				
		return totalEurozoneGDP;
	}
	
	public static void main(String[] args) {
		for (EurozoneCountry c : EurozoneCountry.values())
			System.out.printf("%s GDP per Capita: $%d\n", c, c.getGDPPerCapita());
		System.out.printf("Total Eurozone population: %d\n", getEurozonePopulation());
		System.out.printf("Total Eurozone GDP: $%d millions\n", getEurozoneGDPInMillions());
		System.out.printf("Average Eurozone GDP per Capita: $%d\n", (getEurozoneGDPInMillions() * 1000000)/getEurozonePopulation());
	}
}
