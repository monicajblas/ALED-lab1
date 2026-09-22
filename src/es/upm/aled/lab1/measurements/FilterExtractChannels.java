package es.upm.aled.lab1.measurements;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {

	private int[] validChannels;
	
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels; 
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] medidasOriginales = eeg.getMeasurements(); //Obtengo medidas originales de mi lista 
        Measurement[] medidasFiltradas = new Measurement[medidasOriginales.length]; //array para guardar las medidas con los canales que me interesan
        
        for (int i = 0; i < medidasOriginales.length; i++) {
        	float [] channels = new float [validChannels.length]; //creo un array vacío para guaradar dichos canales 
        	int k = 0;
        		for (int c : validChannels)
        			channels[k++] = medidasOriginales[i].getChannel(c); //guardo en cada medida los canales válidos 
        		medidasFiltradas[i] = new Measurement(channels);
        } 
        return new EEGModel(medidasFiltradas); 
	}

}
