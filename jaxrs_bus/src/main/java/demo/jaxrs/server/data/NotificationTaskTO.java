/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package demo.jaxrs.server.data;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "notificationTask")
@XmlType
public class NotificationTaskTO extends TaskTO {

    private static final long serialVersionUID = 371671242591093846L;

    private final Set<String> recipients = new HashSet<String>();

    private String sender;

    private String subject;

    private String textBody;

    private String htmlBody;

    private boolean executed;

    private String traceLevel;

    @XmlElementWrapper(name = "recipients")
    @XmlElement(name = "recipient")
    public Set<String> getRecipients() {
        return recipients;
    }

    public boolean addRecipient(final String recipient) {
        return recipients.add(recipient);
    }

    public boolean removeRecipient(final String recipient) {
        return recipients.remove(recipient);
    }

    public void setRecipients(final Set<String> recipients) {
        if (this.recipients != recipients) {
            this.recipients.clear();
            if (recipients != null) {
                this.recipients.addAll(recipients);
            }
        }
    }

    public String getSender() {
        return sender;
    }

    public void setSender(final String sender) {
        this.sender = sender;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(final String textBody) {
        this.textBody = textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(final String htmlBody) {
        this.htmlBody = htmlBody;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public String getTraceLevel() {
        return traceLevel;
    }

    public void setTraceLevel(String traceLevel) {
        this.traceLevel = traceLevel;
    }
}
