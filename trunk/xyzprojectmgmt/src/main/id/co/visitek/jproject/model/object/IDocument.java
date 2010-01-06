package id.co.visitek.jproject.model.object;

import java.util.Date;

public interface IDocument extends IPersistentObject  {
	
	public String getName();	
	public String getDocumentNumber();	
	public Date getDate();	
	public String getType();

}
