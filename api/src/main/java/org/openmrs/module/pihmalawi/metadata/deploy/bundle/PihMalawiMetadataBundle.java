package org.openmrs.module.pihmalawi.metadata.deploy.bundle;


import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.bundle.Requires;
import org.openmrs.module.pihmalawi.metadata.PalliativeCareMetadata;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.ChronicHeartFailureConcepts;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.ChronicKidneyDiseaseConcepts;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.ChwManagementConcepts;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.IC3ScreeningConcepts;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.MasterCardConcepts;
import org.openmrs.module.pihmalawi.metadata.deploy.bundle.concept.PalliativeCareConcepts;
import org.springframework.stereotype.Component;

@Component
@Requires( {
        PalliativeCareConcepts.class,
        MasterCardConcepts.class,
        ChwManagementConcepts.class,
        ChronicHeartFailureConcepts.class,
        ChronicKidneyDiseaseConcepts.class,
        IC3ScreeningConcepts.class} )
public class PihMalawiMetadataBundle extends AbstractMetadataBundle{

    @Override
    public void install() throws Exception {
        install(PalliativeCareMetadata.PALLIATIVE_CARE_PROGRAM);
    }
}
