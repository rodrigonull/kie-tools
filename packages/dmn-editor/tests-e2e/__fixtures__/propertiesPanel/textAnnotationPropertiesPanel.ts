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

import { Page } from "@playwright/test";
import { Diagram } from "../diagram";
import { ShapeProperties } from "./parts/shapeProperties";
import { PropertiesPanelBase } from "./propertiesPanelBase";
import { FontProperties } from "./parts/fontProperties";
import { DescriptionProperties } from "./parts/descriptionProperties";

export class TextAnnotationProperties extends PropertiesPanelBase {
  private descriptionProperties: DescriptionProperties;
  private fontProperties: FontProperties;
  private shapeProperties: ShapeProperties;

  constructor(
    public diagram: Diagram,
    public page: Page
  ) {
    super(diagram, page);
    this.descriptionProperties = new DescriptionProperties(this.panel());
    this.fontProperties = new FontProperties(this.panel());
    this.shapeProperties = new ShapeProperties(this.panel());
  }

  public async setFormat(args: { newFormat: string }) {
    await this.panel().getByPlaceholder("Enter a text format...").fill(args.newFormat);
    await this.panel().getByPlaceholder("Enter a text format...").press("Tab");
  }

  public async getFormat() {
    return await this.panel().getByPlaceholder("Enter a text format...").inputValue();
  }

  public async setText(args: { newText: string }) {
    await this.panel().getByPlaceholder("Enter text...").fill(args.newText);
    await this.panel().getByPlaceholder("Enter text...").press("Tab");
  }

  public async getText() {
    return await this.panel().getByPlaceholder("Enter text...").inputValue();
  }

  public async setDescription(args: { newDescription: string }) {
    await this.descriptionProperties.setDescription({ ...args });
  }

  public async getDescription() {
    return await this.descriptionProperties.getDescription();
  }

  public async setFont(args: {
    fontSize?: string;
    bold?: boolean;
    italic?: boolean;
    underline?: boolean;
    striketrough?: boolean;
    color?: string;
    fontFamily?: string;
  }) {
    await this.fontProperties.setFont({ ...args });
  }

  public async resetFont() {
    await this.fontProperties.resetFont();
  }

  public async getFont() {
    return await this.fontProperties.getFont();
  }

  public async setShape(args: { width: string; height: string }) {
    await this.shapeProperties.setShape({ ...args });
  }

  public async setPosition(args: { x: string; y: string }) {
    await this.shapeProperties.setPosition({ ...args });
  }

  public async getShape() {
    return await this.shapeProperties.getShape();
  }

  public async resetShape() {
    await this.shapeProperties.resetShape();
  }

  public async setFillColor(args: { color: string }) {
    await this.shapeProperties.setFillColor({ ...args });
  }

  public async setStrokeColor(args: { color: string }) {
    await this.shapeProperties.setStrokeColor({ ...args });
  }
}
