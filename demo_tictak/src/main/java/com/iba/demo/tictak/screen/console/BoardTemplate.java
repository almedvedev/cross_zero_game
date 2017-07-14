package com.iba.demo.tictak.screen.console;

/**
 * @author Pavel Bekish
 */
public class BoardTemplate {

	public StringBuilder buildTemplate(Integer size) {
		StringBuilder sb = new StringBuilder();
		sb.append(Primitives.NEXT_LINE);
		
		for(int i = 0; i < size - 1; i++) {
			sb.append(drawColumn(size))
				.append(Primitives.NEXT_LINE)
				.append(drawDividingColumn(size))
				.append(Primitives.NEXT_LINE);
		}
		
		sb.append(drawColumn(size))
			.append(Primitives.NEXT_LINE);
		
		return sb;
	}
	
	private String drawColumn(Integer size) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < size - 1; i++) {
			sb.append(Primitives.EMPTY)
				.append(Primitives.VERTICAL_BORDER);
		}
		sb.append(Primitives.EMPTY);
		
		return sb.toString();
	}
	
	private String drawDividingColumn(Integer size) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < size - 1; i++) {
			sb.append(Primitives.HORIZONTAL_BORDER)
				.append(Primitives.CROSS);
		}
		sb.append(Primitives.HORIZONTAL_BORDER);
		
		return sb.toString();
	}
	
}
