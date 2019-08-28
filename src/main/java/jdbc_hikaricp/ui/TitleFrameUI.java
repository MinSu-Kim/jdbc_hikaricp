package jdbc_hikaricp.ui;

import java.sql.SQLException;
import java.util.List;

import jdbc_hikaricp.dto.Title;
import jdbc_hikaricp.service.TitleService;
import jdbc_hikaricp.ui.content.AbstractPanel;
import jdbc_hikaricp.ui.content.PanelTitle;
import jdbc_hikaricp.ui.list.AbstractList;
import jdbc_hikaricp.ui.list.TitleList;

@SuppressWarnings("serial")
public class TitleFrameUI extends AbstractFrameUI<Title> {
	private TitleService titleService;
	
	public TitleFrameUI(String title) {
		super(title);
		titleService = TitleService.getInstance();
	}
	
	@Override
	protected AbstractList<Title> createListPanel(){
		return new TitleList();
	}
	
	@Override
	protected AbstractPanel<Title> createContentPanel(){
		return new PanelTitle("직책 정보");
	}

	@Override
	protected void clearContent() {
		pContent.clearComponent(itemList.size() == 0 ? 1 : itemList.size() + 1);
	}
	
	@Override
	public List<Title> getListAll(){
		try {
			return titleService.selectTitleAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void updateItem(Title item) throws SQLException {
		titleService.updateTitle(item);
	}

	@Override
	protected void insertItem(Title item) throws SQLException {
		titleService.createTitle(item);
	}
	
	@Override
	protected void deleteItem(Title item) throws SQLException {
		titleService.removeTitle(item);
	}
}
