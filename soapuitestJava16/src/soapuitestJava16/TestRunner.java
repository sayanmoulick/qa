package soapuitestJava16;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;

public class TestRunner {
	@Test
	public void SoapTest() throws XmlException, IOException, SoapUIException {
		// TODO Auto-generated method stub
				WsdlProject project = new WsdlProject("//home//sayan//Downloads//RahulShettyAcademySOAPUI//AxesAutomation-soapui-project.xml");
				
				WsdlTestSuite testsuite = project.getTestSuiteByName("PositiveTestSuite");
				
				for(int i=0; i<testsuite.getTestCaseCount();i++) {
					WsdlTestCase testcase = testsuite.getTestCaseAt(i);
					WsdlTestCaseRunner runner = testcase.run(new PropertiesMap(), false);
					Assert.assertEquals(Status.FINISHED, runner.getStatus());
				}
	}
}
