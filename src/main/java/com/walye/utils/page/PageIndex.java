package com.walye.utils.page;

public class PageIndex {

	private int endIndex;

	private int startIndex;

	public static PageIndex getPageIndex(int viewpagecount, int currentPage,
			int totalpage) {
		int startpage = currentPage
				- (viewpagecount % 2 == 0 ? viewpagecount / 2 - 1
						: viewpagecount / 2);
		int endpage = currentPage + viewpagecount / 2;
		if (startpage < 1) {
			startpage = 1;
			if (totalpage >= viewpagecount)
				endpage = viewpagecount;
			else
				endpage = totalpage;
		}
		if (endpage > totalpage) {
			endpage = totalpage;
			if ((endpage - viewpagecount) > 0)
				startpage = endpage - viewpagecount + 1;
			else
				startpage = 1;
		}
		return new PageIndex(startpage, endpage);
	}

	public PageIndex(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
