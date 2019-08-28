package jdbc_hikaricp.ui;

import java.sql.SQLException;

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
		pContent.clearComponent(itemList == null ? 1 : itemList.size() + 1);
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

	@Override
	protected void initService() {
		titleService = TitleService.getInstance();		
	}

	@Override
	protected void reloadItemList() {
		itemList = pList.getItemList();
	}
}
