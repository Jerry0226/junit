package com.ztesoft.ztp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import org.jacoco.core.data.ExecutionData;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.ISessionInfoVisitor;
import org.jacoco.core.data.SessionInfo;
import org.jacoco.core.runtime.RemoteControlReader;


public class TestJacocoAnt {
	public static void main(String[] args) throws IOException {
		String exexFilePath = "F:/jacoco/NewJacoco/exec/jacoco_com.zsmart.unittest.zcipserver.bll.Test4CICommandbll-testDeleteCICommandDto.exec";
		final ExecutionDataStore edata = new ExecutionDataStore();
		File fileExec = new File(exexFilePath);
		FileInputStream fileIn = new FileInputStream(fileExec);
		final RemoteControlReader reader = new RemoteControlReader(fileIn);
		reader.setSessionInfoVisitor(new ISessionInfoVisitor() {
			public void visitSessionInfo(SessionInfo info) {
			}
		});
		reader.setExecutionDataVisitor(edata);
		// Send a dump command and read the response:
		//重置数据
		reader.read();
		
		Collection<ExecutionData> list = edata.getContents();
		for (ExecutionData data : list) {
			System.out.println(data.getId() + " " + data.getName()  + "  \nProbes: " + data.getProbes());
		}
	}
}
