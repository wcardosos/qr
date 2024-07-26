import React from 'react';
import { QrCode } from 'lucide-react'

export function Logo() {
  return (
    <div className="text-cyan-500 flex gap-1 items-center">
      <span className="font-bold text-2xl">qr</span>
      <QrCode />  
    </div>
  )
}