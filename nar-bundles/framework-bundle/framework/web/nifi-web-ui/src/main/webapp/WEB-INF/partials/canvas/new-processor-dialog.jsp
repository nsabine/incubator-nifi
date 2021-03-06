<%--
 Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" session="false" %>
<div id="new-processor-dialog">
    <div class="dialog-content">
        <div id="processor-type-filter-controls">
            <div id="processor-type-filter-container">
                <input type="text" id="processor-type-filter"/>
                <div id="processor-type-filter-options"></div>
            </div>
            <div id="processor-type-filter-status">
                Displaying&nbsp;<span id="displayed-processor-types"></span>&nbsp;of&nbsp;<span id="total-processor-types"></span>
            </div>
        </div>
        <div id="tag-cloud-container">
            <div class="setting">
                <div class="setting-name">Tags</div>
                <div class="setting-field">
                    <ul id="tag-cloud"></ul>
                    <div id="tag-cloud-separator"></div>
                    <ul id="tag-filter"></ul>
                </div>
            </div>
        </div>
        <div id="processor-types-container">
            <div id="processor-types-table"></div>
            <div id="processor-description-container">
                <div id="processor-type-name" class="ellipsis"></div>
                <div id="processor-type-description" class="ellipsis multiline"></div>
                <span class="hidden" id="selected-processor-name"></span>
                <span class="hidden" id="selected-processor-type"></span>
            </div>
        </div>
        <div class="clear"></div>
    </div>
</div>
