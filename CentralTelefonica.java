package ar.edu.unlam.pb1.dominio;

public class CentralTelefonica {
	private static final Integer CANTIDAD_MAXIMA_LLAMADAS = 1000;

	private Integer numero;
	private String nombre;
	private Llamada[] llamadas;
	
	public CentralTelefonica() {
		// TODO: completar el constructor
		this.numero = numero;
		this.nombre = nombre;
		Llamada llamadas[]= new Llamada[CANTIDAD_MAXIMA_LLAMADAS];

	}

	public CentralTelefonica(Integer numero, String nombre) {
		this.numero = numero;
		this.nombre = nombre;
		Llamada llamadas[]= new Llamada[CANTIDAD_MAXIMA_LLAMADAS];
	}
	/**
	 * Ingresa una llamada al array de llamadas
	 * 
	 * @param llamada Llamada que se ingresara
	 * @return verdadero en caso de exito
	 */
	public boolean registrarLlamada(Llamada llamada) {
		boolean ingresada = false;

		// TODO: Validar que la llamada no exista utilizando su identificador
		for(int i=0; i<llamadas.length;i++) {
			if(buscarPorId(llamada.getId() )== null) {
				llamadas[i] = llamada;
			}
		}
		
		return ingresada;
	}

	/**
	 * Busca el identificador maximo de las llamadas registradas y devuelve este numero incrementado en uno
	 * Si no hay llamadas, debe devolver 1
	 * @return Proximo identificador de llamada
	 * */
	public Integer obtenerSiguienteIdentificadorDeLlamada() {
		Integer idMaximo = 0;
		idMaximo = llamadas[0].getId();
		for(int i=0;i<llamadas.length;i++) {
			if(llamadas[i] != null && idMaximo < llamadas[i].getId()) {
				idMaximo = llamadas[i].getId();
			}
		}
		return idMaximo + 1;
	}

	/**
	 * Obtiene una llamada por su identificador de llamada
	 * 
	 * @param idLlamada Identificador de la llamada
	 * @return llamada que coincide con el identificador o null en caso de no
	 *         existir
	 */
	public Llamada buscarPorId(Integer idLlamada) {
		Llamada llamadaBuscada = null;
		for(int i=0;i<llamadas.length;i++) {
			if(llamadas[i] != null && idLlamada == llamadas[i].getId()) {
				llamadaBuscada = llamadas[i];
				
			}
		}
		
		return llamadaBuscada ;
	}

	/**
	 * Obtiene un array de llamadas nacionales realizadas desde un mismo numero de
	 * origen
	 * 
	 * @param numeroOrigen Numero desde donde se realizaron las llamadas
	 * @return array con las llamadas nacionales del numero de origen proporcionado
	 */
	public Llamada[] obtenerLlamadasNacionalesParaNumeroOrigen(String numeroOrigen) {
		Llamada llamadasNacionales[] = new Llamada[CANTIDAD_MAXIMA_LLAMADAS ];
		Integer indice =0;
		// TODO: ordenar las llamadas antes de devolverlas utilizando el metodo:
		// ordenarLlamadasPorMinutosDescendente()
		for(int i =0;i<llamadas.length;i++) {
			if(llamadas[i].getNumeroTelefonoOrigen().equals(numeroOrigen)) {
				llamadasNacionales[indice++] = llamadas[i];
			}
		}
		ordenarLlamadasPorMinutosDescendente(llamadasNacionales); 
		return llamadasNacionales;
	}

	/**
	 * Obtiene la llamada mas barata basandose en el tipo de llamada proporcionado
	 * 
	 * @param tipoLlamada Tipo de llamada para obtener la llamada mas barata
	 * @return llamada mas barata o null si no existe una para el tipo de llamada
	 */
	public Llamada obtenerLlamadaMasBarata(TipoLlamada tipoLlamada) {
		Llamada laMasBarata = llamadas[0];
		for(int i =0;i<llamadas.length;i++) {
			if(llamadas[i]!=null && llamadas[i].getTipoLlamada().equals(tipoLlamada) && llamadas[i].obtenerCostoLlamada()<llamadas[i+1].obtenerCostoLlamada()) {
				laMasBarata = llamadas[i];
			}
		}
		return laMasBarata;
	}

	/**
	 * Obtiene el promedio de minutos de llamadas internacionales dirigidas a un
	 * mismo numero de destino
	 * 
	 * @param numeroDestino Numero al que se realizaron las llamadas
	 * @return promedio de minutos
	 */
	public Double obtenerPromedioEnMinutosLlamadasInternacionalesParaUnNumeroDestino(String numeroDestino) {
		Double promedio = 0.0;
		Integer contador =0;
		for(int i =0;i<llamadas.length;i++) {
			if(llamadas[i]!=null && llamadas[i].getNumeroTelefonoDestino().equals(numeroDestino)) {
				contador++;
				promedio += llamadas[i].getDuracion();
			}
		}
		return promedio/contador;
	}
	
	/**
	 * Obtiene la cantidad de llamadas realizadas para un tipo de llamada
	 * @param tipoLlamada	Tipo de llamada para obtener la cantidad
	 * @return Cantidad de llamadas realizadas o 0.
	 * */
	public Integer obtenerCantidadDeLlamadasRealizadasPorTipoLlamada(TipoLlamada tipoLlamada) {
		Integer contador =0;
		for(int i =0; i<llamadas.length;i++) {
			if(TipoLlamada.INTERNACIONAL.equals(tipoLlamada) || TipoLlamada.NACIONAL.equals(tipoLlamada)) {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Ordena las llamadas proporcionadas por su duracion en minutos de manera
	 * descendente
	 * 
	 * @param llamadas Llamadas que se ordenaran
	 * @return llamadas ordenadas
	 */
	private Llamada[] ordenarLlamadasPorMinutosDescendente(Llamada[] llamadas) {
		//Llamada llamadasOrdenadas[] = new Llamada[CANTIDAD_MAXIMA_LLAMADAS];
		Llamada auxiliar = null;
		for(int i = 0;i<llamadas.length;i++) {
			for(int j =0; j<llamadas.length-1;j++) {
				if(llamadas[j].getDuracion()<llamadas[j+1].getDuracion()) {
					auxiliar = llamadas[j];
					llamadas[j] = llamadas[j+1];
					llamadas[j+1] = auxiliar;
					
				}
				//
			}
		}
		return llamadas;
	}
}
