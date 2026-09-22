package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {

	private int min;
	private int max; 
	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	public FilterExtractPeriod(int min, int max) {
		this.max = max; 
		this.min = min; 
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement [] medidasOriginales = eeg.getMeasurements(); //Obtengo las medidas del eeg con "getMeasurements" y las guardo en un array 
		
		if(medidasOriginales.length < max && medidasOriginales.length > min) {
			Measurement [] medidasFiltradas = new Measurement [max - min + 1]; //Creo un array de medidas del tamaño del rango que me interesa
			int k = 0;
			
			for(int i = min; i <= max; i++) //Recorro las medidas que me interesan del array original
				medidasFiltradas[k++] = medidasOriginales[i];
			return new EEGModel(medidasFiltradas);
		}
		return new EEGModel();
	}
}
