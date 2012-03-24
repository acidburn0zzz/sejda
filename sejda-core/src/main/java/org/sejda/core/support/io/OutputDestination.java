/*
 * Created on 04/giu/2010
 *
 * Copyright 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
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
package org.sejda.core.support.io;

import org.sejda.core.support.io.Destination.FileDestination;
import org.sejda.core.support.io.Destination.OverwriteFileDestination;
import org.sejda.model.output.DirectoryOutput;
import org.sejda.model.output.FileOutput;
import org.sejda.model.output.StreamOutput;
import org.sejda.model.output.TaskOutput;

/**
 * Concrete implementation of an output destination where output generated by the task will be written to. <br />
 * Usage:
 * 
 * <pre>
 * {@code
 * PdfFileOutput out = ...
 * destination(out).overwriting(false);
 * }
 * </pre>
 * 
 * Or:
 * 
 * <pre>
 * {@code
 * PdfStreamOutput out = ...
 * destination(out);
 * }
 * </pre>
 * 
 * @author Andrea Vacondio
 * 
 */
final class OutputDestination implements OverwriteFileDestination, FileDestination {

    private TaskOutput outputDestination;
    private boolean overwrite = false;

    public OutputDestination(TaskOutput outputDestination, boolean overwrite) {
        this.outputDestination = outputDestination;
        this.overwrite = overwrite;
    }

    private OutputDestination(TaskOutput outputDestination) {
        this.outputDestination = outputDestination;
    }

    public TaskOutput getOutputDestination() {
        return outputDestination;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public FileDestination overwriting(boolean overwrite) {
        this.overwrite = overwrite;
        return this;
    }

}