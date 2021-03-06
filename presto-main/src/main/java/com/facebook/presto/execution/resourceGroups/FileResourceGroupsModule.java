/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.execution.resourceGroups;

import com.facebook.presto.execution.resourceGroups.FileResourceGroupConfigurationManager.ManagerSpec;
import com.facebook.presto.spi.resourceGroups.ResourceGroupConfigurationManager;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

import static io.airlift.configuration.ConfigBinder.configBinder;
import static io.airlift.json.JsonCodecBinder.jsonCodecBinder;

public class FileResourceGroupsModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        jsonCodecBinder(binder).bindJsonCodec(ManagerSpec.class);
        configBinder(binder).bindConfig(FileResourceGroupConfig.class);
        binder.bind(ResourceGroupConfigurationManager.class).to(FileResourceGroupConfigurationManager.class).in(Scopes.SINGLETON);
    }
}
