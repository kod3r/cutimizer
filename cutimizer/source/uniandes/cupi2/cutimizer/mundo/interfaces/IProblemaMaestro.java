package uniandes.cupi2.cutimizer.mundo.interfaces;

import java.util.ArrayList;

/**
 * Interface que indica los servicios b�sicos que debe proveer toda clase que
 * modele un Problema Maestro
 */
public interface IProblemaMaestro {

	/**
	 * Modela que el problema a resolver sea el restringido
	 */
	public static final int ENTERO = 0;
	/**
	 * Modela que el problema a resolver sea la relajaci�n lineal
	 */
	public static final int RELAJACION_LINEAL = 1;

	/**
	 * Retorna el valor de las variables duales del problema Maestro ejecutado
	 * 
	 * @return Retorna un arreglo con los valores de las variables duales
	 * @throws Excepci
	 *             �n si ocurre alg�n problema con el otpimizador
	 */
	public ArrayList<Double> darDuales() throws Exception;

	/**
	 * Informa el valor que tom� la funci�n objetivo en el problema
	 * recientemente ejecutado
	 * 
	 * @return valor de la funci�n objetivo.
	 */
	public double darValorFO() throws Exception;

	/**
	 * Retorna el valor de las variables de decisi�n del problema
	 * 
	 * @return valor de las variables de decisi�n.
	 */
	public ArrayList<Double> darValorVariablesDecision() throws Exception;

	/**
	 * Resuelve el problema de SET COVERING con la informaci�n cargada
	 * 
	 * @param tipoProblema
	 *            El tipoe de problema que se quiere resolver
	 *            IProblemaMaestro.RELAJACION_LINEAL o
	 *            IProblemaMaestro.RESTRINGIDO
	 */
	public void resolver(int tipoProblema) throws Exception;

	/**
	 * Agrega una nueva variable (Columna) al problema maestro
	 * 
	 * @param coeficienteFO
	 *            el coeficiente que acompa�a la variable en la funci�n objetivo
	 * @param coeficienteRestricciones
	 *            el coeficiente que acompa�a la variable en cada una de las
	 *            restricciones
	 * @throws Exception
	 *             si sale alg�n problema del optimizador
	 */
	public void agregarNuevaVariable(int coeficienteFO,
			ArrayList<Integer> coeficienteRestricciones) throws Exception;

}
