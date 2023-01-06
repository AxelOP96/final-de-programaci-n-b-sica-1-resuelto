package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominio.CentralTelefonica;
import ar.edu.unlam.pb1.dominio.Llamada;
import ar.edu.unlam.pb1.dominio.TipoLlamada;

public class GestionDeLlamadas {

	private static final int REGISTRAR_LLAMADA = 1, MOSTRAR_LLAMADA_POR_ID = 2,
			MOSTRAR_LLAMADAS_NACIONALES_MISMO_NUMERO_ORIGEN = 3, MOSTRAR_LLAMADA_MAS_BARATA = 4,
			MOSTRAR_PROMEDIO_DE_MINUTOS_LLAMADAS_INTERNACIONALES_MISMO_NUMERO_DESTINO = 5, MOSTRAR_CANTIDAD_LLAMADAS_REALIZADAS = 6, SALIR = 9;
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		mostrarMensaje("Bienvenido al gestor de llamadas");

		CentralTelefonica centralTelefonica = new CentralTelefonica(1903, "Central telefonica UNLaM");
		int opcion = 0;

		do {
			mostrarMenu();
			opcion = teclado.nextInt();
			Llamada llamada = null;

			switch (opcion) {
			case REGISTRAR_LLAMADA:
				// TODO: ingresar una llamada por teclado utilizando el metodo ingresarLlamadaPorTeclado() de esta clase
				
				// TODO: registrar la llamada en la central consumiendo el metodo registrarLlamada de la central telefonica
				
				// TODO: mostrar un mensaje de exito en caso de poder registrar la llamada o un mensaje de error, en caso de no lograrlo.
				mostrarMensaje("Ingrese una llamada");
				ingresarLlamadaPorTeclado(centralTelefonica);
				mostrarMensaje("Ingrese el id");
				Integer id = teclado.nextInt();
				mostrarMensaje("Ingrese el telefono de origen");
				String origen  = teclado.nextLine();
				mostrarMensaje("Ingrese el telefono de destino");
				String destino  = teclado.nextLine();
				mostrarMensaje("Ingrese la duracion");
				Double duracion = teclado.nextDouble();
				mostrarMensaje("Ingrese el tipo de llamada: 0 para nacional, 1 para internacional");
				Integer opcionNumerica = teclado.nextInt();
				TipoLlamada tipo = null; 
				if(opcionNumerica == 0) {
					tipo = TipoLlamada.NACIONAL;}
					else {
						tipo = TipoLlamada.INTERNACIONAL;
				
				}
				llamada = new Llamada(id, origen, destino, duracion, tipo);
				centralTelefonica.registrarLlamada(llamada);
				if(llamada != null) {
					mostrarMensaje("LLAMADA INGRESADA CORRECTAMENTE");
					
				}else {
					mostrarMensaje("Error ");
				}
				break;
			case MOSTRAR_LLAMADA_POR_ID:
				// TODO: ingresar por teclado el ID de la llamada
				
				// TODO: obtener una llamada consumiendo el metodo buscarPorId() de la central telefonica
				
				// TODO: mostrar la llamada con el metodo toString() de la misma o un mensaje de error en caso de ser null.
				mostrarMensaje("Ingrese el id");
				Integer idBuscado = teclado.nextInt();
				centralTelefonica.buscarPorId(idBuscado);
				
				break;
			case MOSTRAR_LLAMADAS_NACIONALES_MISMO_NUMERO_ORIGEN:
				// TODO: ingresar por teclado el numero de origen
				
				// TODO: obtener las llamadas consumiendo el metodo obtenerLlamadasNacionalesParaNumeroOrigen() de la central telefonica
				
				// TODO: mostrar las llamadas obtenidas con el metodo mostrarLlamadas() de esta clase, solo si no son nulas
				mostrarMensaje("iNGRESE NUMERO DE ORIGEN");
				String origenBuscado = teclado.nextLine();
				centralTelefonica.obtenerLlamadasNacionalesParaNumeroOrigen(origenBuscado);
				//mostrarLlamadas(llamadas[]);
				break;
			case MOSTRAR_LLAMADA_MAS_BARATA:
				// TODO: ingresar por teclado el tipo de llamada
				
				// TODO: obtener la llamada mas barata consumiendo el metodo obtenerLlamadaMasBarata de la central telefonica
				
				// TODO: mostrar un mensaje mostrando la llamada mas barata o un mensaje de error en caso de ser null
				mostrarMensaje("Ingrese el tipo de llamada: 0 para nacional, 1 para internacional");
				Integer opcionNumero = teclado.nextInt();
				TipoLlamada tipoNuevo = null; 
				if(opcionNumero == 0) {
					tipo = TipoLlamada.NACIONAL;}
					else {
						tipo = TipoLlamada.INTERNACIONAL;
				
				}
				if(centralTelefonica.obtenerLlamadaMasBarata(tipoNuevo)!=null) {
					mostrarMensaje("la llamada mas barata es "+ centralTelefonica.obtenerLlamadaMasBarata(tipoNuevo));
				}else {
					mostrarMensaje("Error");
				}
				//centralTelefonica.obtenerLlamadaMasBarata(tipoNuevo);
				break;
			case MOSTRAR_PROMEDIO_DE_MINUTOS_LLAMADAS_INTERNACIONALES_MISMO_NUMERO_DESTINO:
				// TODO: Ingresar por teclado el numero de destino
				
				// TODO: obtener el promedio consumiendo el metodo obtenerPromedioEnMinutosLlamadasInternacionalesParaUnNumeroDestino de la central telefonica
				
				// TODO: mostrar el promedio por pantalla
				System.out.println("Ingrese el destino");
				String numeroDestino = teclado.nextLine();
				centralTelefonica.obtenerPromedioEnMinutosLlamadasInternacionalesParaUnNumeroDestino(numeroDestino);
				break;
			case MOSTRAR_CANTIDAD_LLAMADAS_REALIZADAS:
				// TODO: obtener la cantidad de llamadas nacionales e internacionales realizadas consumiendo el metodo obtenerCantidadDeLlamadasRealizadasPorTipoLlamada() de la central telefonica

				// TODO: mostrar por pantalla ambas cantidades en un mismo mensaje.
				
				break;
			case SALIR:
				mostrarMensaje("Hasta luego!");
				break;
			}

		} while (opcion != SALIR);
	}
	
	/**
	 * Ingresa una llamada por teclado
	 * @param centralTelefonica	Central telefonica para obtener el siguiente identificador de llamada
	 * @return Llamada ingresada
	 * */
	private static Llamada ingresarLlamadaPorTeclado(CentralTelefonica centralTelefonica) {
		// TODO: obtener el proximo identificador de la llamada consumiendo el metodo obtenerSiguienteIdentificadorDeLlamada() de la central telefonica
		return new Llamada(1, "44445555", "55554444", 3.2, TipoLlamada.NACIONAL);
	}

	private static void mostrarLlamadas(Llamada[] llamadas) {
		for (int i = 0; i < llamadas.length; i++) {
			if (llamadas[i] != null) {
				mostrarMensaje("\n" + llamadas[i].toString());
			}
		}
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

	private static void mostrarMenu() {
		mostrarMensaje("\nMenu principal");
		mostrarMensaje("1 - Registrar llamada");
		mostrarMensaje("2 - Mostrar llamada por su identificador");
		mostrarMensaje("3 - Mostrar llamadas nacionales para un mismo numero de origen");
		mostrarMensaje("4 - Mostrar llamada mas barata para un tipo de llamada");
		mostrarMensaje(
				"5 - Mostrar promedio de minutos para llamadas internacionales realizadas a un mismo numero de destino");
		mostrarMensaje(
				"6 - Mostrar cantidad de llamadas nacionales e internacionales realizadas");
		mostrarMensaje("9 - Salir");
	}

}
