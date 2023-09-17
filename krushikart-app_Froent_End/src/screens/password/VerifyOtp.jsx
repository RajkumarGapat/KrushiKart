import React, { useState } from 'react'
import { Container } from 'react-bootstrap'
import { Navigate, useNavigate } from 'react-router-dom'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { toast, Toaster } from 'react-hot-toast'

const VerifyOtp = () => {
  //   const [email, setEmail] = useState('')
  const [otp, setotp] = useState('')
  const navigate = useNavigate()
  

  const handleSubmit = async (e) => {
    e.preventDefault()
    const email = localStorage.getItem('email')
    try {
      const res = await httpClient.get(`${base_url}/api/user/verify`, {
        params: { email, otp },
        
      })

      if (res.status === 200) {
        toast.success('Verified successfully')
        localStorage.setItem('token', res.data.jwt)
        navigate('/api/user/newpassword')
      } else {
        toast.error('Something went wrong...')
      }
    } catch (error) {}
  }
  return (
    <div>
      <h1>verify opt</h1>
      <div>
        <div className="row mb-4 ">
          <div className="col-4">
            <form onSubmit={handleSubmit}>
              {/* Email input */}
              {/* <div className="form-outline mb-4">
                <input
                  type="email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  id="otp"
                  className="form-control"
                  placeholder="Entert the Email Address"
                />
              </div> */}

              <div className="form-outline mb-4">
                <input
                  type="number"
                  value={otp}
                  onChange={(e) => setotp(e.target.value)}
                  id="otp"
                  className="form-control"
                  placeholder="Entert the otp"
                />
              </div>

              <hr />

              <div className="row mb-4">
                <div className="col">
                  <div className="form-outline">
                    <div className="text-center">
                      <button
                        type="submit"
                        className="btn btn-primary btn-block mb-4 "
                      >
                        verify otp
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      )
    </div>
  )
}
export default VerifyOtp
