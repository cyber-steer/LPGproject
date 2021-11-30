import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DateSearch extends JPanel {
	/**
	 * Create the panel.
	 */
	JSpinner spinner;
	public DateSearch() {
		Date now = new Date();
		SpinnerDateModel model = new SpinnerDateModel(now, null, now,Calendar.DAY_OF_WEEK);
		spinner = new JSpinner(model);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //변수 사용시 사용
		
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner,"yyyy-MM-dd");
		
		spinner.setEditor(editor); //포멧 형식
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				Date value = (Date) model.getValue();
				Date next = (Date) model.getNextValue();
			}
		});
		JPanel panel = new JPanel();
		panel.add(spinner);
		add(panel);
	}

}
