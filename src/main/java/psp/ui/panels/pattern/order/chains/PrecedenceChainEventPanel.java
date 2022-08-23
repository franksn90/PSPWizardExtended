/**
 *
 * Copyright (C) 2011-2014 Swinburne University of Technology
 *
 * This file is part of PSPWizard, a tool for machine-assisted 
 * definition of temporal formulae capturing pattern-based system
 * properties, developed at the Faculty of Science, Engineering and
 * Technology at Swinburne University of Technology, Australia.
 * The patterns, structured English grammar and mappings are due to
 *
 *   Marco Autili, Universita` dell'Aquila
 *   Lars Grunske, University of Stuttgart
 *   Markus Lumpe, Swinburne University of Technology
 *   Patrizio Pelliccione, University of Gothenburg
 *   Antony Tang, Swinburne University of Technology
 *
 * Details about the PSP framework can found in
 *   "Aligning Qualitative, Real-Time, and Probabilistic
 *    Property Specification Patterns Using a Structured
 *    English Grammar"
 *
 *
 * PSPWizard is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * PSPWizard is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PSPWizard; see the file COPYING.  If not, write to
 * the Free Software Foundation, 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */

package psp.ui.panels.pattern.order.chains;

import psp.constraints.TimeBound;
import psp.engine.PSPController;
import psp.sel.EventImpl;
import psp.sel.patterns.order.ChainEvent;
import psp.ui.dialogs.TimeBoundDialog;
import psp.ui.dialogs.UpperTimeBoundDialog;

public class PrecedenceChainEventPanel extends javax.swing.JPanel implements ChainEventPanelFeatures
{
    private PSPController fPSPController;
    private ChainEvent fChainEvent;
    private PrecedenceChainEventSequencePanel fHostPanel;

    public void setHostPanel( PrecedenceChainEventSequencePanel aHostPanel )
    {
        fHostPanel = aHostPanel;
    }
    
    public ChainEvent getChainEvent() 
    {
        return fChainEvent;
    }

    public void setChainEvent( ChainEvent aChainEvent ) 
    {
        fChainEvent = aChainEvent;
        
        fTi.setSelectedItem( fChainEvent.getEvent() );
        if ( fChainEvent.getConstraint() != null  )
            fZi.setSelectedItem( fChainEvent.getConstraint().getEvent() );
        else
            fZi.setSelectedIndex( 0 );
    }

    public PrecedenceChainEventPanel() 
    {
        initComponents();
        
        fChainEvent = new ChainEvent();
    }

    public void setController( PSPController aPSPController ) 
    {
        fPSPController = aPSPController;

        fTi.setController( fPSPController );
        fZi.setController( fPSPController );
    }

    public void updateEvents() 
    {
        fTi.updateEvents();
        fZi.updateEvents();
    }

    private void updateChainEvent()
    {
        fChainEvent.setEvent( (EventImpl)fTi.getSelectedItem() );
        fChainEvent.setConstraint( (EventImpl)fZi.getSelectedItem() );

        if ( fHostPanel != null )
            fHostPanel.updateSelection();
    }
    
    private boolean isEventSelectionPossible( EventImpl aEvent )
    {
        if ( fPSPController != null )
            return fPSPController.isPatternEventSelectionPossible( aEvent );
        else
            return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fRemoveButton = new javax.swing.JButton();
        fAddButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fTimeBoundButton = new javax.swing.JButton();
        fTi = new psp.ui.util.EventComboBox();
        fZi = new psp.ui.util.ContraintComboBox();

        setMaximumSize(new java.awt.Dimension(500, 88));
        setMinimumSize(new java.awt.Dimension(0, 88));

        fRemoveButton.setText("-");
        fRemoveButton.setMaximumSize(new java.awt.Dimension(45, 29));
        fRemoveButton.setMinimumSize(new java.awt.Dimension(45, 29));
        fRemoveButton.setPreferredSize(new java.awt.Dimension(45, 29));
        fRemoveButton.setSize(new java.awt.Dimension(45, 29));
        fRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fRemoveButtonActionPerformed(evt);
            }
        });

        fAddButton.setText("+");
        fAddButton.setMaximumSize(new java.awt.Dimension(45, 29));
        fAddButton.setMinimumSize(new java.awt.Dimension(45, 29));
        fAddButton.setPreferredSize(new java.awt.Dimension(45, 29));
        fAddButton.setSize(new java.awt.Dimension(45, 29));
        fAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fAddButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("and afterwards");

        fTimeBoundButton.setText("Upper Time Bound");
        fTimeBoundButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fTimeBoundButtonActionPerformed(evt);
            }
        });

        fTi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fTiActionPerformed(evt);
            }
        });

        fZi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fZiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(fTi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fTimeBoundButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fZi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fTi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fTimeBoundButton)
                    .addComponent(fZi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fAddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fRemoveButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(fRemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fRemoveButtonActionPerformed
        // Remove Panel
        
        if ( fHostPanel != null )
        {
            fHostPanel.deletePanel( this );
        }
    }//GEN-LAST:event_fRemoveButtonActionPerformed

    private void fAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fAddButtonActionPerformed
        // Add new Panel
        
        if ( fHostPanel != null )
        {
            PrecedenceChainEventPanel lNewEvent = new PrecedenceChainEventPanel();
            fHostPanel.addPanel( lNewEvent );
        }
    }//GEN-LAST:event_fAddButtonActionPerformed

    private void fTimeBoundButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fTimeBoundButtonActionPerformed
        // Upper time bound
        
        TimeBoundDialog lDialog = new UpperTimeBoundDialog( fPSPController );        
        TimeBound lNewTimeBound = lDialog.showDialog( fChainEvent.getEvent(), fChainEvent.getTimeBound() );
        
        if ( lNewTimeBound == null )
            fTimeBoundButton.setText( "Upper Time Bound" );
        else
            fTimeBoundButton.setText( lNewTimeBound.toString() );
        
        fChainEvent.setTimeBound( lNewTimeBound );

        if ( fHostPanel != null )
            fHostPanel.updateSelection();
    }//GEN-LAST:event_fTimeBoundButtonActionPerformed

    private void fTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fTiActionPerformed
        // event selected

        EventImpl lEvent = (EventImpl)fTi.getSelectedItem();
        
        if ( lEvent != null )
        {
            if ( fTi.isStable( lEvent ) || isEventSelectionPossible( lEvent ) )
            {
                fTi.acceptSelection();
                updateChainEvent();
            }
            else
                fTi.revertSelection();
        }
    }//GEN-LAST:event_fTiActionPerformed

    private void fZiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fZiActionPerformed
        // constraint event selected
        EventImpl lEvent = (EventImpl)fZi.getSelectedItem();
        
        if ( lEvent != null )
        {
            if ( fZi.isStable( lEvent ) || isEventSelectionPossible( lEvent ) )
            {
                fZi.acceptSelection();
                updateChainEvent();
            }
            else
                fZi.revertSelection();
        }
    }//GEN-LAST:event_fZiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fAddButton;
    private javax.swing.JButton fRemoveButton;
    private psp.ui.util.EventComboBox fTi;
    private javax.swing.JButton fTimeBoundButton;
    private psp.ui.util.ContraintComboBox fZi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
