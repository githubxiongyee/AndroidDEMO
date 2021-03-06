package com.yaful.android.ioc.download;

import com.yaful.android.ioc.app.Ioc;
import com.yaful.android.ioc.db.annotation.Foreign;
import com.yaful.android.ioc.db.sqlite.WhereBuilder;

/*
 * Author: pan Email:gdpancheng@gmail.com
 * Created Date:2014-2-14
 * Copyright @ 2014 BU
 * Description: 类描述
 *
 * History:
 */
public class ThreadEntity {

	private int id;
	protected long start;
	protected long end;
	protected long load;
	
	@Foreign(column = "ThreadId", foreign = "id")
	public FileEntity fileEntity;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public long getLoad() {
		return load;
	}

	public void setLoad(long load) {
		this.load = load;
	}

	public FileEntity getFileEntity() {
		return fileEntity;
	}

	public void setFileEntity(FileEntity fileEntity) {
		this.fileEntity = fileEntity;
	}
	public static void delete(int id) {
		Ioc.getIoc().getDb().delete(ThreadEntity.class, WhereBuilder.b("ThreadId","=",id));
	}
	@Override
    public String toString() {
	    return "ThreadEntity [id=" + id + ", start=" + start + ", end=" + end + ", load=" + load + "]";
    }
}
