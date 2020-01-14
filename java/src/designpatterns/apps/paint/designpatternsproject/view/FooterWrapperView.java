package designpatternsproject.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FooterWrapperView extends JPanel {
	LoggerView loggerView;
	InformationPaneView informationPaneView;
	JLabel lblHeader;
	/**
	 * Create the panel.
	 */
	public FooterWrapperView(LoggerView loggerView, InformationPaneView informationPaneView) {
		this.loggerView = loggerView;
		this.informationPaneView = informationPaneView;
		setLayout(new BorderLayout(0, 0));

		add(loggerView, BorderLayout.CENTER);

		add(informationPaneView, BorderLayout.SOUTH);

		lblHeader = new JLabel("Live action log");
		add(lblHeader, BorderLayout.NORTH);

	}

	public LoggerView getLoggerView() {
		return loggerView;
	}

	public InformationPaneView getInformationPaneView() {
		return informationPaneView;
	}

	public JLabel getLblHeader() {
		return lblHeader;
	}

}
