package webServicesTest;

import java.io.IOException;

import org.apache.xmlbeans.XmlException;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
//import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCaseRunner;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.support.SoapUIException;

public class testRunner {

	public static void main(String[] args) throws XmlException, IOException, SoapUIException {
		// TODO Auto-generated method stub
		WsdlProject project = new WsdlProject("//home//sayan//Downloads//RahulShettyAcademySOAPUI//Amazon-soapui-project.xml");
		
		WsdlTestSuite testsuite = project.getTestSuiteByName("PositiveTestSuite");
		
		for(int i=0; i<testsuite.getTestCaseCount();i++) {
			WsdlTestCase testcase = testsuite.getTestCaseAt(i);
//			WsdlTestCaseRunner runner = testcase.run(new PropertiesMap(), false);
			testcase.run(new PropertiesMap(), false);
		}
	}
}
