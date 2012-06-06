package uniandes.cupi2.cutimizer.mundo;

/**
 * Modela un item en una soluci�n dada
 * 
 * @author jsierrajur
 */
public class ItemSolucion {

	/**
	 * Si la orientaci�n es invertida en el item representado
	 */
	public static final int INVERTIDA = 1;
	/**
	 * Si la orientaci�n es igual a la del item representado
	 */
	public static final int ORIGINAL = 0;

	/**
	 * La posici�n x del item
	 */
	private int x;

	/**
	 * La posici�n y del item
	 */
	private int y;
	/**
	 * El item que representa la instancia
	 */
	private Item representado;

	/**
	 * La orientaci�n que se encuentra el item en el patr�n
	 */
	private int orientacion;

	/**
	 * Construye una nueva instancia con los par�metros dados
	 * 
	 * @param x
	 * @param y
	 * @param representado
	 */
	public ItemSolucion(int x, int y, Item representado, int orientacion) {
		this.x = x;
		this.y = y;
		this.orientacion = orientacion;
		this.representado = representado;
	}

	/**
	 * Da la coordenada x del item
	 * 
	 * @return la coordenada x del item
	 */
	public int getCoordenadaX() {
		return x;
	}

	/**
	 * Da el Item que representa esta isntacia
	 * 
	 * @return el item representado
	 */
	public Item getRepresentado() {
		return representado;
	}

	/**
	 * Asigna el item representado por esta instancia
	 * 
	 * @param representado
	 *            el item representado
	 */
	public void setRepresentado(Item representado) {
		this.representado = representado;
	}

	/**
	 * Da la coordenada y del item
	 * 
	 * @return la coordenada y
	 */
	public int getCoordenadaY() {
		return y;
	}

	/**
	 * Da la orientaci�n del item dado
	 * 
	 * @return la orientaci�n del item
	 */
	public int darOrientacion() {
		return orientacion;
	}

	@Override
	public String toString() {
		String resumen;
		if (orientacion == ORIGINAL)
			resumen = "Item #" + representado.darID() + " de tama�o " + representado.getAncho() + "x"
					+ representado.getAlto() + "x"
					+ representado.getEspesor() + " mm ubicado en la posici�n ("
					+ getCoordenadaX() + "," + getCoordenadaY() + ") mm de la l�mina"
					+ '\n';

		else
			resumen = "Item #" + representado.darID() + " de tama�o " + representado.getAlto() + "x"
					+ representado.getAncho() + "x"
					+ representado.getEspesor() + " mm ubicado en la posici�n ("
					+ getCoordenadaX() + "," + getCoordenadaY() + ") mm de la l�mina"
					+ '\n';

		return resumen;
	}
}
