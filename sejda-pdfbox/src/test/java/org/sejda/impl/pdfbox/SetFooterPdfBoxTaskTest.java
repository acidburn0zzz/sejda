/*
 * Copyright 2012 by Eduard Weissmann (edi.weissmann@gmail.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.sejda.impl.pdfbox;

import org.sejda.core.service.SetFooterTaskTest;
import org.sejda.impl.pdfbox.component.DefaultPdfSourceOpener;
import org.sejda.impl.pdfbox.component.PDDocumentHandler;
import org.sejda.model.exception.TaskException;
import org.sejda.model.input.PdfFileSource;
import org.sejda.model.input.PdfSource;
import org.sejda.model.parameter.SetFooterParameters;
import org.sejda.model.task.Task;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Weissmann
 */
public class SetFooterPdfBoxTaskTest extends SetFooterTaskTest {

    public Task<SetFooterParameters> getTask() {
        return new SetFooterTask();
    }

    protected void assertSpecificFooterExpectations(File result) throws TaskException, IOException {
        PdfSource<?> source = PdfFileSource.newInstanceNoPassword(result);
        PDDocumentHandler handler = source.open(new DefaultPdfSourceOpener());

        assertThat(handler.extractFooterText(1).trim(), is("Introduction"));
        assertThat(handler.extractFooterText(2).trim(), is("Introduction"));
        assertThat(handler.extractFooterText(3).trim(), is("100"));
        assertThat(handler.extractFooterText(4).trim(), is("101"));
    }


}
