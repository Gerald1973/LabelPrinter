package com.smilesmile1973.controller.school;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.smilesmile1973.Constants;
import com.smilesmile1973.I18NUtils;
import com.smilesmile1973.controller.MainController;
import com.smilesmile1973.label.CellPageLabel;
import com.smilesmile1973.label.PageLabel;
import com.smilesmile1973.label.StickLabel;
import com.smilesmile1973.model.school.SchoolModel;
import com.smilesmile1973.ms.word.Document;
import com.smilesmile1973.ms.word.PageSetup;
import com.smilesmile1973.ms.word.Table;
import com.smilesmile1973.view.school.SchoolFrame;
import com.smilesmile1973.vo.SchoolVO;

public class SchoolController {
	private SchoolFrame schoolFrame;
	private SchoolModel schoolModel;
	private MainController mainController;

	public SchoolController(MainController mainController) {
		initModel();
		this.mainController = mainController;
		schoolFrame = new SchoolFrame(schoolModel);
		schoolFrame.setVisible(true);
		initListeners();
	}

	private void initListeners() {
		schoolFrame.getMainPanel().addInsertButtonListener(new Listener() {
			public void handleEvent(Event event) {
				SchoolVO schoolVO = new SchoolVO();
				schoolVO.setCourse(schoolFrame.getCourseValue());
				schoolVO.setFirstName(schoolFrame.getFirstNameValue());
				schoolVO.setName(schoolFrame.getFamilyNameValue());
				schoolVO.setRoom(schoolFrame.getRoomValue());
				Document document = mainController.getWord().getActiveDocument();
				document.setParagraphSpacingBeforeAfter(0, 0);
				PageSetup pageSetup = document.getPageSetup();
				pageSetup.setTopMargin(1.5f);
				pageSetup.setRightMargin(0.97f);
				pageSetup.setBottomMargin(1.5f);
				pageSetup.setLeftMargin(0.97f);
				StickLabel stickLabel = new StickLabel(6.35f, 3.81f);
				PageLabel pageLabel = new PageLabel(pageSetup.getPageWidth(), pageSetup.getHeight(),
						pageSetup.getTopMargin(), pageSetup.getRightMargin(), pageSetup.getBottomMargin(),
						pageSetup.getBottomMargin(), stickLabel);
				document.addTable(pageLabel.getNumberOfRows(), pageLabel.getNumberOfColumns());
				Table table = document.getTable(1);
				int border = Constants.BORDERBOTTOM | Constants.BORDERRIGHT | Constants.BORDERBOTTOM
						| Constants.BORDERLEFT;
				CellPageLabel cells[][] = pageLabel.getCellDimensions();
				for (int y = 0; y < pageLabel.getNumberOfRows(); y++) {
					for (int x = 0; x < pageLabel.getNumberOfColumns(); x++) {
						table.setSizeOfCell(y + 1, x + 1, cells[y][x].getWidth(), cells[y][x].getHeight());
						table.setBorderCell(y + 1, x + 1, Constants.WDLINESTYLEDASHDOT, Constants.WDLINEWIDTH025PT,
								border);
						if (cells[y][x].isLabel()) {
							//table.setCellPadding(y + 1, x + 1, Constants.DEFAULT_PADDING, Constants.DEFAULT_PADDING,
							//	Constants.DEFAULT_PADDING, Constants.DEFAULT_PADDING);
							table.addPictureInCell(y + 1, x + 1, "To reimplement");
							table.setTextInCell(y + 1, x + 1, schoolVO.getString());
						}
					}
				}
			}
		});

		schoolFrame.getMainPanel().addCancelButtonListener(new Listener() {
			public void handleEvent(Event event) {
				schoolFrame.dispose();
			}
		});

	}

	private void initModel() {
		schoolModel = new SchoolModel();
		schoolModel.setCourse(I18NUtils.INSTANCE.getString("school.course"));
		schoolModel.setFamilyName(I18NUtils.INSTANCE.getString("school.family.name"));
		schoolModel.setFirstName(I18NUtils.INSTANCE.getString("school.first.name"));
		schoolModel.setRoom(I18NUtils.INSTANCE.getString("school.room"));
		schoolModel.setShellTitle(I18NUtils.INSTANCE.getString("school.shell.title"));
		schoolModel.setCancel(I18NUtils.INSTANCE.getString("school.cancel"));
		schoolModel.setInsert(I18NUtils.INSTANCE.getString("school.insert"));
		schoolModel.setBrowse(I18NUtils.INSTANCE.getString("school.browse"));
	}
}
