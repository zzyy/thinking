package _annotation.dev;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import _annotation.AnnotationLocation;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("TestValue")
public class TestValueProcessor extends AbstractProcessor {
	private ProcessingEnvironment processingEnv;
	private TypeElement assignmentEle;
	
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		this.processingEnv = processingEnv;
		Elements elementUtils = processingEnv.getElementUtils();
		assignmentEle = elementUtils.getTypeElement("TestValue");
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		System.out.println("********process*********");
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(assignmentEle);
		for(Element ele : elements){
			processTestValue(ele);
		}
		return false;
	}
	
	private void processTestValue(Element element){
		new AnnotationLocation().sayHi("zy");
	}

}
