package oripa.viewsetting.main.uipanel;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import oripa.domain.cptool.TypeForChange;

public class FromLineTypeItemListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		UIPanelSettingDB settingDB = UIPanelSettingDB.getInstance();
		
		if(e.getStateChange() == ItemEvent.SELECTED){
			settingDB.setTypeFrom(
					(TypeForChange)e.getItem());	

		}
	}
}
