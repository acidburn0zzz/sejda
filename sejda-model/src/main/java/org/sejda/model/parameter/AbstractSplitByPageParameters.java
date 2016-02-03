/*
 * Created on 03/ago/2011
 * Copyright 2010 by Andrea Vacondio (andrea.vacondio@gmail.com).
 * 
 * This file is part of the Sejda source code
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.sejda.model.parameter;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.sejda.model.optimization.OptimizationPolicy;
import org.sejda.model.parameter.base.OptimizableOutputTaskParameters;
import org.sejda.model.parameter.base.SinglePdfSourceMultipleOutputParameters;
import org.sejda.model.pdf.page.PagesSelection;

/**
 * Skeletal implementation for a split by page parameter class.
 * 
 * @author Andrea Vacondio
 * 
 */
public abstract class AbstractSplitByPageParameters extends SinglePdfSourceMultipleOutputParameters
        implements PagesSelection, OptimizableOutputTaskParameters {
    @NotNull
    private OptimizationPolicy optimizationPolicy = OptimizationPolicy.NO;

    @Override
    public OptimizationPolicy getOptimizationPolicy() {
        return optimizationPolicy;
    }

    @Override
    public void setOptimizationPolicy(OptimizationPolicy optimizationPolicy) {
        this.optimizationPolicy = optimizationPolicy;
    }

    /**
     * @param upperLimit
     *            upper limit for the pages set.
     * @return the set of pages to split at. All pages are greater then 0 and lesser then upperLimit.
     */
    @Override
    public abstract Set<Integer> getPages(int upperLimit);

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(optimizationPolicy).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbstractSplitByPageParameters)) {
            return false;
        }
        AbstractSplitByPageParameters parameter = (AbstractSplitByPageParameters) other;
        return new EqualsBuilder().appendSuper(super.equals(other))
                .append(optimizationPolicy, parameter.optimizationPolicy).isEquals();
    }
}
