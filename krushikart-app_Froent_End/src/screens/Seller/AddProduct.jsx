import SellerMenus from './SellerMenus'
import React, { useEffect, useState } from 'react'
import base_url from '../../api/bootapi'
import httpClient from '../../http-common'
import { useAuth } from '../../context/auth'
import toast from 'react-hot-toast'
import { Modal } from 'antd'
import { Select } from 'antd'
import { useNavigate } from 'react-router-dom'
const { Option } = Select

const AddProduct = () => {
  const navigate = useNavigate()
  const [categories, setCategories] = useState([])
  const [prodName, setProdName] = useState('')
  const [prodDesc, setProdDesc] = useState('')
  const [unitPrice, setUnitPrice] = useState('')
  const [prodQuantity, setProdQuantity] = useState('')
  const [prodWeight, setProdWeight] = useState('')
  const [special_specification, setSpecial_specification] = useState('')
  const [mfgDate, setMfgDate] = useState('')
  const [category, setCategory] = useState('')
  const [photo, setPhoto] = useState('')
  const token = localStorage.getItem('user')

  //get all category
  const getAllCategory = async () => {
    try {
      const { data } = await httpClient.get(`${base_url}/api/category/view`)
      setCategories(data)
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    getAllCategory()
  }, [])

  const handleCreate = async (e) => {
    console.log(token)
    e.preventDefault()
    try {
      // const productData = new FormData()
      // productData.append('prodName', prodName)
      // productData.append('prodDesc', prodDesc)
      // productData.append('unitPrice', unitPrice)
      // productData.append('prodQuantity', prodQuantity)
      // productData.append('photo', photo)
      // productData.append('prodWeight', prodWeight)
      // productData.append('special_specification', special_specification)
      // productData.append('mfgDate', mfgDate)

      const res = await httpClient.post(
        `${base_url}/api/prod/add/${category}`,
        // {
        //   params: {
        //     catName: category,
        //   },
        // },
        {
          prodName,
          prodDesc,
          unitPrice,
          prodQuantity,
          photo,
          prodWeight,
          special_specification,
          mfgDate,
          // productData,
        },
        // {
        //   headers: {
        //     Authorization: token,
        //   },
        // },
      )

      console.log(category)
      console.log(prodName)
      console.log(prodDesc)
      console.log(unitPrice)
      console.log(prodQuantity)
      console.log(prodWeight)
      console.log(special_specification)
      console.log(mfgDate)

      if (res.status === 200) {
        //   toast.error()
        // } else {
        toast.success('Product Created Successfully')
        // navigate('/dashboard/admin/products')
        navigate('/')
      } else {
        toast.error('Something is wrong...')
      }
    } catch (error) {
      console.log(error)
      toast.error('something went wrong')
    }
  }

  return (
    <div className="container-fluid m-3 p-3 dashboard">
      <div className="row">
        <div className="col-md-3">
          <SellerMenus />
        </div>
        <div className="col-md-9">
          <h1>Add Products</h1>

          <div className="m-1 w-75">
            <Select
              bordered={false}
              placeholder="Select a category"
              size="large"
              showSearch
              className="form-select mb-3"
              onChange={(value) => {
                setCategory(value)
              }}
            >
              {categories?.map((c) => (
                <Option key={c.id} value={c.categoryName}>
                  {c.categoryName}
                </Option>
              ))}
            </Select>

            <div className="mb-3">
              <label className="btn btn-outline-secondary col-md-12">
                {photo ? photo.name : 'Upload Photo'}
                <input
                  type="file"
                  name="photo"
                  accept="image/*"
                  onChange={(e) => setPhoto(e.target.files[0])}
                  hidden
                />
              </label>
            </div>
            <div className="mb-3">
              {photo && (
                <div className="text-center">
                  <img
                    src={URL.createObjectURL(photo)}
                    alt="product_photo"
                    height={'200px'}
                    className="img img-responsive"
                  />
                </div>
              )}
            </div>
            <div className="mb-3">
              <input
                type="text"
                value={prodName}
                placeholder="write a name"
                className="form-control"
                onChange={(e) => setProdName(e.target.value)}
              />
            </div>

            <div className="mb-3">
              <textarea
                type="text"
                value={prodDesc}
                placeholder="write a description"
                className="form-control"
                onChange={(e) => setProdDesc(e.target.value)}
              />
            </div>

            <div className="mb-3">
              <input
                type="number"
                value={unitPrice}
                placeholder="write a Price"
                className="form-control"
                onChange={(e) => setUnitPrice(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <input
                type="number"
                value={prodQuantity}
                placeholder="write a quantity"
                className="form-control"
                onChange={(e) => setProdQuantity(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <input
                type="number"
                value={prodWeight}
                placeholder="write a weight"
                className="form-control"
                onChange={(e) => setProdWeight(e.target.value)}
              />
            </div>
            <div className="mb-3">
              <textarea
                type="text"
                value={special_specification}
                placeholder="write a special specification"
                className="form-control"
                onChange={(e) => setSpecial_specification(e.target.value)}
              />
            </div>

            <div className="mb-3">
              <input
                type="text"
                value={mfgDate}
                onChange={(e) => setMfgDate(e.target.value)}
                id="dob"
                className="form-control"
                placeholder="Enter the Date Of mgf (yyyy-mm-dd)"
              />
            </div>
            {/* </div>
            <div className="mb-3">
              <Select
                bordered={false}
                placeholder="Select Shipping "
                size="large"
                showSearch
                className="form-select mb-3"
                onChange={(value) => {
                  setShipping(value)
                }}
              >
                <Option value="0">No</Option>
                <Option value="1">Yes</Option>
              </Select>
            </div> */}
            <div className="mb-3">
              <button className="btn btn-primary" onClick={handleCreate}>
                CREATE PRODUCT
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddProduct
