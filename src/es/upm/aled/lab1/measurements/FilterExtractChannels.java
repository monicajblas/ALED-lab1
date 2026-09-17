package es.upm.aled.lab1.measurements;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels extends EEGModel implements Filter {

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
		Measurement[] original = eeg.getMeasurements();
        Measurement[] filtradas = new Measurement[original.length];
        
        for (int i = 0; i < original.length; i++) {
            float[] channels = new float[validChannels.length];
            for (int j = 0; j < validChannels.length; j++) {
                channels[j] = original[i].getChannel(validChannels[j]);
            }
            filtradas[i] = new Measurement(channels);
        }
       
		return new EEGModel(filtradas);
	}

}
