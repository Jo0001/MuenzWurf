package wuerfler;

public class Muenze {

	private int wurf;

	public int gibLetzterWurf() {
		return wurf;
	}

	public void werfen() {
		double temp = 0;

		temp = Math.random();

		if (temp > 0.5) {

			wurf = 1;

		} else {
			wurf = 0;
		}

	}

}
