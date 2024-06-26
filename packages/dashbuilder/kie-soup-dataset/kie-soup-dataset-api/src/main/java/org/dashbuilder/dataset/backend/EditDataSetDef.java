/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.dashbuilder.dataset.backend;

import java.util.List;

import org.dashbuilder.dataset.def.DataColumnDef;
import org.dashbuilder.dataset.def.DataSetDef;

/**
 * <p>Response model for a DataSetDef edition.</p>
 * <p>Provides a cloned DataSetDef instance from the original one and the original column definition list.</p>
 */
public class EditDataSetDef {

    private DataSetDef definition;
    private List<DataColumnDef> columns;

    public EditDataSetDef() {
        
    }

    public EditDataSetDef(final DataSetDef definition, final List<DataColumnDef> columns) {
        this.definition = definition;
        this.columns = columns;
    }

    public DataSetDef getDefinition() {
        return definition;
    }

    public List<DataColumnDef> getColumns() {
        return columns;
    }
    
}
