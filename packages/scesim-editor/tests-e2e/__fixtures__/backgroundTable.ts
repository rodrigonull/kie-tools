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

import { ProjectName } from "@kie-tools/playwright-base/projectNames";
import { Page } from "@playwright/test";

export class BackgroundTable {
  constructor(
    public page: Page,
    public projectName: ProjectName
  ) {}

  public get() {
    return this.page.getByLabel("Background").getByTestId("standalone-bee-table").locator("div").first();
  }

  public async fill(args: { content: string; columnNumber: number }) {
    await this.page.getByLabel("Background").getByTestId("monaco-container").nth(args.columnNumber).dblclick();
    if (this.projectName === ProjectName.GOOGLE_CHROME) {
      // Google Chrome's fill function is not always erasing the input content
      await this.page.getByLabel("Editor content;Press Alt+F1 for Accessibility Options.").press("Control+A");
    }
    // FEEL text input selector when the monaco editor is selected.
    await this.page.getByLabel("Editor content;Press Alt+F1 for Accessibility Options.").fill(args.content);
    await this.page.keyboard.press("Home");
    await this.page.keyboard.press("Enter");
  }

  public async clickPlusIcon() {
    await this.page.getByLabel("Background").locator("svg").click();
  }

  public getPlusIcon() {
    return this.page.getByLabel("Background").locator("svg");
  }
}
