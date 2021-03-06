package bla.tm.steps.partners;

import bla.tm.pages.site.partners.Partners_CertifiedPartnersPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertEquals;

public class Partners_CertifiedPartnersSteps {

    Partners_CertifiedPartnersPage certifiedPartnersPage;

    @Step
    public void openPage() {
        certifiedPartnersPage.open();
    }

    @Step
    public void maximiseBrowserWindow() {
        certifiedPartnersPage.maximisePageWindow();
    }

    @Step
    public void checkIfTitleIsCorrect(){
        assertEquals (certifiedPartnersPage.getTitleText(), certifiedPartnersPage.pageHeader);
    }

    @Step
    public void checkGeneralPageElements(boolean disqus, boolean leftMenu){
        certifiedPartnersPage.checkGeneralPageElements(disqus, leftMenu);
    }
}
